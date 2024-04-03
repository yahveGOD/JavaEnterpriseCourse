package org.example.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.main.controller.AbilityController;
import org.example.main.dto.AbilityDto;
import org.example.main.entity.Ability;
import org.example.main.repository.AbilityRepository;
import org.example.main.repository.HeroRepository;
import org.example.main.service.AbilityService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
@ComponentScan
public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new ApplicationContext() {
            @Override
            public String getId() {
                return null;
            }

            @Override
            public String getApplicationName() {
                return null;
            }

            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public long getStartupDate() {
                return 0;
            }

            @Override
            public ApplicationContext getParent() {
                return null;
            }

            @Override
            public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
                return null;
            }

            @Override
            public BeanFactory getParentBeanFactory() {
                return null;
            }

            @Override
            public boolean containsLocalBean(String name) {
                return false;
            }

            @Override
            public boolean containsBeanDefinition(String beanName) {
                return false;
            }

            @Override
            public int getBeanDefinitionCount() {
                return 0;
            }

            @Override
            public String[] getBeanDefinitionNames() {
                return new String[0];
            }

            @Override
            public <T> ObjectProvider<T> getBeanProvider(Class<T> requiredType, boolean allowEagerInit) {
                return null;
            }

            @Override
            public <T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType, boolean allowEagerInit) {
                return null;
            }

            @Override
            public String[] getBeanNamesForType(ResolvableType type) {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(ResolvableType type, boolean includeNonSingletons, boolean allowEagerInit) {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(Class<?> type) {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit) {
                return new String[0];
            }

            @Override
            public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
                return null;
            }

            @Override
            public <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit) throws BeansException {
                return null;
            }

            @Override
            public String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType) {
                return new String[0];
            }

            @Override
            public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) throws BeansException {
                return null;
            }

            @Override
            public <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType, boolean allowFactoryBeanInit) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public <A extends Annotation> Set<A> findAllAnnotationsOnBean(String beanName, Class<A> annotationType, boolean allowFactoryBeanInit) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public Object getBean(String name) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
                return null;
            }

            @Override
            public Object getBean(String name, Object... args) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> requiredType) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
                return null;
            }

            @Override
            public <T> ObjectProvider<T> getBeanProvider(Class<T> requiredType) {
                return null;
            }

            @Override
            public <T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType) {
                return null;
            }

            @Override
            public boolean containsBean(String name) {
                return false;
            }

            @Override
            public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public Class<?> getType(String name, boolean allowFactoryBeanInit) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public String[] getAliases(String name) {
                return new String[0];
            }

            @Override
            public void publishEvent(Object event) {

            }

            @Override
            public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
                return null;
            }

            @Override
            public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
                return null;
            }

            @Override
            public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
                return null;
            }

            @Override
            public Environment getEnvironment() {
                return null;
            }

            @Override
            public Resource[] getResources(String locationPattern) throws IOException {
                return new Resource[0];
            }

            @Override
            public Resource getResource(String location) {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }
        };
        ObjectMapper objectMapper = new ObjectMapper();
        AbilityRepository abilityRepository = new AbilityRepository();
        AbilityService abilityService = new AbilityService(abilityRepository);
        AbilityController abilityController = new AbilityController(abilityService,objectMapper);
        AbilityDto abilityDto = new AbilityDto(1,abilityController.findAll().get(1).getHero(),"1","1","1",123,true);
        System.out.println(abilityController.getJson());
        abilityController.deleteById(1);
        abilityController.EditUpdate(0,abilityDto);
        System.out.println(abilityController.getJson());
    }
}
