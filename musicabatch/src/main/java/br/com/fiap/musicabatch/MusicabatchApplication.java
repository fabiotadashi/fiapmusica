//package br.com.fiap.musicabatch;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
//
//import java.io.File;
//import java.nio.file.Paths;
//
//@SpringBootApplication
//@EnableBatchProcessing
//public class MusicabatchApplication {
//
//    Logger logger = LoggerFactory.getLogger(MusicabatchApplication.class);
//
//    public static void main(String[] args) {
//        SpringApplication.run(MusicabatchApplication.class, args);
//    }
//
//    @Bean
//    public Tasklet clearFile(@Value("${file.musica}") String path) {
//        return (stepContribution, chunkContext) -> {
//            File file = Paths.get(path).toFile();
//            if (file.delete()) {
//                logger.info("Arquivo deletado com sucesso");
//            } else {
//                logger.info("Erro ao deletar arquivo");
//            }
//            return RepeatStatus.FINISHED;
//        };
//    }
//
//    @Bean
//    public Step clearFileStep(
//            StepBuilderFactory stepBuilderFactory,
//            Tasklet tasklet
//    ){
//        return stepBuilderFactory.get("Clear file step")
//                .tasklet(tasklet)
//                .allowStartIfComplete(true)
//                .build();
//    }
//
//    @Bean
//    public Job clearFileJob(
//            JobBuilderFactory jobBuilderFactory,
//            Step step
//    ){
//        return jobBuilderFactory.get("Clear file job")
//                .start(step)
//                .build();
//    }
//
//}
