pipeline {
    agent any
tools {
        MAVEN_HOME = tool 'Maven'
        PATH = "${MAVEN_HOME}/bin:${PATH}"
    }
    stages {
        stage('Build') {
            steps {
                // Clone your Selenium project from source control
                git url: 'https://github.com/Atefkhess/selenium_cucumber_.git'

 

                // Build your Selenium project using Maven or Gradle
                sh 'mvn clean test' // or 'gradle clean test'

 

                // Archive your test reports
                junit 'AutomationQa\target\cucumber-report.json'
            }
        }
    }
}
