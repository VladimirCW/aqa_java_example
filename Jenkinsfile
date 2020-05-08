pipeline {
    agent any

    stages{
        stage('Preparation') {
            steps {
                git 'https://github.com/VladimirCW/aqa_java_example.git'
            }
        }
        stage('Unit tests') {
            steps{
                sh 'mvn clean -DsuiteXmlFile=unit-testng.xml test'
            }
        }
    }

}