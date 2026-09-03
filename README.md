# REST Assured API Test Automation Framework

A production-ready API test automation framework built using **Java**, **REST Assured**, and **TestNG**. Designed with clean architecture principles, emphasizing serialization/deserialization (POJO), centralized request specifications, and data-driven testing.

---

## 🛠️ Tech Stack & Dependencies

* **Language:** Java 17 / 11
* **API Engine:** REST Assured
* **Test Runner:** TestNG
* **Build Tool:** Apache Maven
* **Serialization / Parsing:** Jackson / Gson
* **Reporting:** TestNG Surefire Reports / ExtentReports
* **Continuous Integration:** GitHub Actions

---

## 📂 Framework Architecture

```text
RestAssured_Automation_API_Framework
├── src/main/java
│   ├── com/api/endpoints/      # API Routes, URIs, and HTTP Methods
│   ├── com/api/payloads/       # POJO classes for Request & Response models
│   └── com/api/utilities/      # DataProvider, ConfigReader, ExtentReportManager
├── src/test/java
│   └── com/api/tests/          # Test classes containing TestNG assertions
├── src/test/resources
│   ├── config.properties       # Environment variables (Base URL, Auth Tokens)
│   ├── routes.properties       # API endpoint paths
│   └── testdata.xlsx / .json   # External test data for Data-Driven tests
├── testng.xml                  # Test suite runner configuration
└── pom.xml                     # Maven dependencies and Surefire plugin
```

---

## ✨ Key Framework Features

* **Separation of Concerns:** Isolated endpoint routes, payload models, and test logic.
* **POJO Serialization:** Request bodies and response validations are strongly typed using POJO classes.
* **Reusable Specifications:** Pre-configured `RequestSpecification` and `ResponseSpecification` for base URIs, headers, and authentication tokens.
* **Schema Validation:** Built-in JSON schema validation to prevent API contract breaking changes.
* **Data-Driven Testing:** Integrated with external files (Excel/JSON) using TestNG `@DataProvider`.

---

## 🚀 How to Set Up and Run Locally

### Prerequisites
* JDK 11 or higher installed (`java -version`)
* Apache Maven installed (`mvn -version`)

### 1. Clone the repository
```bash
git clone https://github.com/yashawanth-patil/RestAssured_Automation_API_Framework.git

cd RestAssured_Automation_API_Framework
```

### 2. Execute tests via Maven
Run the full test suite using the TestNG XML configuration:
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

---

## 📊 Reports & Test Artifacts
After execution, detailed HTML test execution reports are generated at:
* `target/surefire-reports/emailable-report.html`
* `target/surefire-reports/index.html`
