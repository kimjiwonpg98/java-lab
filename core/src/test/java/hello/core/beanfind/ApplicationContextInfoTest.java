package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("연결된 빈 출력")
    void findAllBean () {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name =" + beanDefinitionName + "object = " + bean);

        }
    }


//    BeanDefinition.ROLE_APPLICATION: 직접 등록한 어플리케이션 빈
//    BeanDefinition.ROLE_INFRASTRUCTURE: 스프링 내부에서 사용하는 빈
    @Test
    @DisplayName("어플리케이션 빈 출력")
    void findApplicationBean () {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("외부: name =" + beanDefinitionName + "object = " + bean);
            }

            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("내부: name =" + beanDefinitionName + "object = " + bean);
            }
        }
    }
}
