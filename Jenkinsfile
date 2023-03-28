pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/Atefkhess/selenium_cucumber_'

                // Run Maven on a Unix agent.
               // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
          stage('Rapport de test') {
            steps {
                // Utilisez l'étape junit pour générer le rapport de test
                junit 'target/surefire-reports/**/*.xml'
            }
            post {
                always {
                    // Archivez les fichiers de résultats de test pour une utilisation ultérieure
                    archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                }
            }
        }

    }
}
