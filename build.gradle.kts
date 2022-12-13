plugins {
	id("org.springframework.boot") version "2.6.7"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.jmailen.kotlinter") version "3.3.0"
	kotlin("jvm") version "1.5.30"
	kotlin("plugin.spring") version "1.5.30"
	kotlin("plugin.serialization") version "1.5.30"
	kotlin("kapt") version "1.4.20"
}

group = "com.mcontigo"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}


dependencies {
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.springframework.boot:spring-boot-starter-jdbc")
		implementation("org.springframework.boot:spring-boot-starter-web")
	    implementation("org.springframework.boot:spring-boot-starter-validation")
		implementation("org.springframework.ws:spring-ws-core")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.postgresql:postgresql:42.2.18")
		implementation("org.springframework.cloud:spring-cloud-starter-config")
		implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
		implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
		implementation("io.github.openfeign:feign-httpclient:11.2")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation ("io.github.openfeign:feign-jackson:9.3.1")
		implementation("com.h2database:h2")
		implementation("org.hibernate:hibernate-envers")
		implementation("io.springfox:springfox-swagger2:2.9.2")
		implementation("io.springfox:springfox-swagger-ui:2.9.2")

		testImplementation(kotlin("test"))
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("com.github.tomakehurst:wiremock-jre8:2.25.1")
		testImplementation ("org.mockito.kotlin:mockito-kotlin:3.2.0")

		api("org.mapstruct:mapstruct:1.4.1.Final")
		kapt("org.mapstruct:mapstruct-processor:1.4.1.Final")
		kapt("org.springframework.boot:spring-boot-configuration-processor")
		developmentOnly("org.springframework.boot:spring-boot-devtools")

}

extra["springCloudVersion"] = "2021.0.3"
dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
	maxParallelForks = 10
}
