package com.vtxlab.demo.helloworld.demo_sb_restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication // @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
// @SpringBootApplication 是 Spring Boot 提供的一個整合性標註，結合了 @SpringBootConfiguration、@EnableAutoConfiguration 和 @ComponentScan 的功能
// 這個標註用於標記主啟動類別，同時會自動配置 Spring Boot 應用程式所需的設定

// ! @ComponentScan -> Serach the whole project, check if any @Controller, @Service, @Repository,
// !@Configuration, @Component
// @ComponentScan 標註用於掃描整個專案，檢查是否有被標記為 @Controller、@Service、@Repository、@Configuration 或 @Component 的類別

// @Controller, @Service, @Repository, @Configuration are a type of Component
// @Controller、@Service、@Repository 和 @Configuration 都是 Spring Framework 中的組件標註，用於標記不同類型的組件，讓 Spring 能夠識別和管理它們

// @Controller：用於標記控制器類別，通常處理 HTTP 請求和回應，並將結果呈現給用戶。
// @Service：用於標記服務類別，通常包含應用程式的業務邏輯，並被其他組件（如控制器或其他服務）調用。
// @Repository：用於標記資料存取物件（如 DAO），通常用於對資料庫或其他資料來源進行操作。
// @Configuration：用於標記配置類別，通常包含 Spring Bean 的定義和配置。

// @Component 是一個通用的組件標註，用於標記任何一個 Spring 組件，沒有特定的角色。
// 如果一個類別沒有更具體的組件標註（如 @Controller、@Service 或 @Repository），
// 您可以使用 @Component 來讓 Spring 知道這是一個組件

public class DemoSbRestfulApplication {

	public static ConfigurableApplicationContext context; // 將 ConfigurableApplicationContext 類型的變數 context 宣告為 public static
	// 是 Spring Framework 提供的一個介面
	// 它擴展了 ApplicationContext 接口，提供了設定和管理應用程式上下文的功能
	// 通常用於設定 Spring 應用程式上下文的各種屬性和設定，並提供了相關的方法

	public static void main(String[] args) { // 使用 SpringApplication.run() 方法來啟動 Spring Boot 應用程式
		context = SpringApplication.run(DemoSbRestfulApplication.class, args);
	} // 通過這樣的方式，您可以在應用程式的整個生命週期中使用 context 變數來訪問和管理 Spring 應用程式上下文

	// 應用程式上下文 = Application Context, 用於管理和提供 Spring 應用程式的配置資訊、Bean 實例和功能
	// 就像是 Spring 應用程式的「大腦」，負責管理整個應用程式的運作。它包含了所有在應用程式中配置的 Bean 定義，並負責實例化這些 Bean、解析它們之間的依賴關係，以及提供運行時的功能和資源。
	//簡單來說，應用程式上下文就是一個容器，裡面存放著應用程式所需的一切資源和配置。當 Spring 應用程式啟動時，它會建立應用程式上下文，並根據配置資訊來初始化和管理整個應用程式
}
