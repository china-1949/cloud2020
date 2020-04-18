







以前cloud使用的是Dalston.SR1,boot使用为1.x的版本
现在由于boot使用了2.x版本，则cloud使用了H 版本

https://github.com/spring-projects/spring-boot/releases
需要升级boot版本
https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Release-Notes

Springcloud的版本控制
https://github.com/spring-projects/spring-cloud/wiki


Spring的官网介绍springcloud版本
https://spring.io/projects/spring-cloud#learn


Springcloud和springboot版本匹配：
https://spring.io/projects/spring-cloud#overview


详细的查看
https://start.spring.io/actuator/info


版本演示：



Springboot2.2.2.RELEASE文档说明
https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/html/
Springcloud Hoxton.SR3 使用boot版本


Springcloud Hoxton.SR1 使用boot版本






这样做的好处就是: 如果有多个子项目都引用同一样的依赖,则可以避免在每个使用的子项目里都声明一个版本号,这样想升级或切换到另一个版本时,只需在顶层父容器里更新,而不需要一个一个子项目的修改l;另外如果某个子项目需要另外的一个版本,只需声明version版本 


Springboot 热部署配置
1、Pom文件
<!--热部署相关的-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>

<!--全局使用热部署-->
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <configuration>
        <fork>true</fork>
        <addResources>true</addResources>
      </configuration>
    </plugin>
  </plugins>
</build>


2.Idea工具配置


接下来快捷键
Crt+shift+Alt+/    如下勾选2个



RestTmeplate 的接口调用‘




https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html

Springboot配置config
//需要引入ResTemplate
@Configuration
public class ApplicationContextConfig {
    @Bean  //注入容器
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
这样就可以调用后台提供者


