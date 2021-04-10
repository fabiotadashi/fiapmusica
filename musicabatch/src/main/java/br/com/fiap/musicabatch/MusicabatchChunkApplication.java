package br.com.fiap.musicabatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@SpringBootApplication
@EnableBatchProcessing
public class MusicabatchChunkApplication {

    Logger logger = LoggerFactory.getLogger(MusicabatchChunkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MusicabatchChunkApplication.class, args);
    }

    @Bean
    public ItemReader<Musica> readFile(@Value("${file.chunk}") Resource resource) {
        return new FlatFileItemReaderBuilder<Musica>()
                .name("CSV Musica Reader")
                .resource(resource)
                .targetType(Musica.class)
                .delimited().delimiter(";").names("titulo", "autor")
                .build();
    }

    @Bean
    public ItemProcessor<Musica, Musica> musicaItemProcessor(){
        return (musica) -> {
            musica.setTitulo(musica.getTitulo().toLowerCase().trim());
            musica.setAutor(musica.getAutor().trim());
            return musica;
        };
    }

    @Bean
    public ItemWriter<Musica> musicaItemWriter(
            DataSource dataSource
    ){
        return new JdbcBatchItemWriterBuilder<Musica>()
                .dataSource(dataSource)
                .sql("insert into TB_MUSICA (titulo, autor) values (:titulo, :autor)")
                .beanMapped()
                .build();
    }

    @Bean
    public Step musicaStep(
        StepBuilderFactory stepBuilderFactory,
        ItemReader<Musica> itemReader,
        ItemProcessor<Musica, Musica> itemProcessor,
        ItemWriter<Musica> itemWriter
    ){
        return stepBuilderFactory.get("Musica chunk step: csv to database")
                .<Musica, Musica>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public Job musicaJob(
            JobBuilderFactory jobBuilderFactory,
            Step step
    ){
        return jobBuilderFactory.get("Musica Job")
                .start(step)
                .build();
    }

}
