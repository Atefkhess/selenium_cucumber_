pipeline {
    agent any
    
    stages {
        stage('Git') {
            steps {
                git branch: 'master', url: 'https://github.com/Atefkhess/selenium_cucumber_'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('Rapport de test') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber-report.json",
                    jsonReportDirectory:'target'
            }
        }
    }
}
