pipeline {
	agent { node { label 'platformrunner' } }
  	environment {
        BRANCHES = "${env.GIT_BRANCH}"
        COMMIT = "${env.GIT_COMMIT}"
        RELEASE_NAME = "keycloakadapterserver"
        SERVICE_PORT = 8080
        REGISTRY_URL = "751503455312.dkr.ecr.us-east-1.amazonaws.com/platform/core/plf-keycloak-adapter"
    }
    stages {
        stage('build') {
            steps {
                sh '/opt/gradle/gradle-5.2.1/bin/gradle clean build --refresh-dependencies --stacktrace -Dk8s.db.env=db-config-k8s'
                sh 'aws ecr get-login --no-include-email --region us-east-1'
                sh 'docker build -t "$REGISTRY_URL:latest" .'
                sh 'eval $(aws ecr get-login --no-include-email | sed \'s|https://||\')'
                sh 'docker push "$REGISTRY_URL:latest"'
            }
        }
        stage('deploy') {
            steps {
                sh 'sudo -s kubectl delete -f /deployment/keycloak-adapter.yaml'
                sh 'sudo -s sleep 5s'
                sh 'sudo -s kubectl create -f /deployment/keycloak-adapter.yaml'                
            }
        }
    }
}
