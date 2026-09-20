pipeline {
    agent any

    tools {
        jdk 'JDK11'
        maven 'Maven3'
    }

    parameters {
        choice(name: 'ENVIRONMENT', choices: ['dev', 'cert', 'prod'], description: 'Ambiente a ejecutar')
        string(name: 'TEST_TAGS', defaultValue: '@CaeqFinanciadoCallCenter_CE', description: 'Tags de Cucumber')
        booleanParam(name: 'HEADLESS', defaultValue: true, description: 'Ejecutar navegador en modo headless')
    }

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    environment {
        MAVEN_OPTS = '-Xmx1024m'
        CONFIG_BROWSER_HEADLESS = "${params.HEADLESS}"
        CONFIG_ENVIRONMENT_NOTIFICATION_SENDSTATUS = 'false'
        CONFIG_ENVIRONMENT_NOTIFICATION_SENDREPORTE = 'false'
        APPLICATION_JXRAY_INTEGRATION = 'off'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and run tests') {
            steps {
                withCredentials([
                    string(credentialsId: 'upc-db-url', variable: 'APPLICATION_SPRING_DATASOURCE_URL'),
                    string(credentialsId: 'upc-db-username', variable: 'APPLICATION_SPRING_DATASOURCE_USERNAME'),
                    string(credentialsId: 'upc-db-password', variable: 'APPLICATION_SPRING_DATASOURCE_PASSWORD'),
                    string(credentialsId: 'upc-db-driver', variable: 'APPLICATION_SPRING_DATASOURCE_DRIVER_CLASS_NAME'),
                    string(credentialsId: 'upc-api-secret', variable: 'CONFIG_CREDENTIAL_API_SECRET'),
                    string(credentialsId: 'upc-cert-password', variable: 'CONFIG_CREDENTIAL_CERTIFICATE_PASSWORD'),
                    string(credentialsId: 'upc-supervisor-doc-type', variable: 'CONFIG_CREDENTIAL_USER_DOCUMENTTYPESUPERVISOR'),
                    string(credentialsId: 'upc-supervisor-doc-number', variable: 'CONFIG_CREDENTIAL_USER_DOCUMENTNUMBERSUPERVISOR'),
                    string(credentialsId: 'upc-supervisor-username', variable: 'CONFIG_CREDENTIAL_USER_USERNAMESUPERVISOR'),
                    string(credentialsId: 'upc-supervisor-password', variable: 'CONFIG_CREDENTIAL_USER_PASSWORDNAMESUPERVISOR'),
                    string(credentialsId: 'upc-user-cc', variable: 'CONFIG_CREDENTIAL_USER_USERNAMECC'),
                    string(credentialsId: 'upc-password-cc', variable: 'CONFIG_CREDENTIAL_USER_USERPASSWORDCC'),
                    string(credentialsId: 'upc-user-st', variable: 'CONFIG_CREDENTIAL_USER_USERNAMEST'),
                    string(credentialsId: 'upc-password-st', variable: 'CONFIG_CREDENTIAL_USER_USERPASSWORDST'),
                    file(credentialsId: 'upc-apim-pfx', variable: 'PFX_CERT_FILE')
                ]) {
                    powershell '''
                        $ErrorActionPreference = "Stop"
                        New-Item -ItemType Directory -Force -Path "src\\test\\resources\\certificado" | Out-Null
                        Copy-Item -Path $env:PFX_CERT_FILE -Destination "src\\test\\resources\\certificado\\apim-client-certificate.pfx" -Force
                        mvn clean verify "-Dmaven.repo.local=C:\\Users\\earce\\.m2\\repository" "-Denvironment=$env:ENVIRONMENT" "-Dcucumber.filter.tags=$env:TEST_TAGS"
                    '''
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*', allowEmptyArchive: true
            junit allowEmptyResults: true, testResults: 'target/failsafe-reports/*.xml'
            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/spark/html-report',
                reportFiles: 'Index.html',
                reportName: 'Extent HTML Report'
            ])
            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/site',
                reportFiles: '*.html',
                reportName: 'Cucumber HTML Report'
            ])
        }
    }
}
