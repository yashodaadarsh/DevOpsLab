pipeline{
    agent any
    stages{
        stage('Fetching Code Changes Detected'){
            steps{
                git branch: 'main', url: 'https://github.com/yashodaadarsh/DevOpsLab.git'
            }
        }

        stage('Build Code'){
            steps{
                sh 'mvn install -DskipTests'
            }
            post{
                success{
                    echo "Archiving the built artifacts..."
                    archiveArtifacts artifacts: '**/*.jar'
                }
            }
        }

        stage('Run Tests'){
            steps{
                sh 'mvn test'
            }
        }

        stage('Creating the Docker Image'){
            
            steps{
                script {
                    def image = docker.build("yashodaadarsh/devopslab05images:${env.BUILD_NUMBER}", ".")
                    echo "Docker image created: ${image.id}"
                }
            }
        }

        stage('Running the Docker Container'){
            steps{
                sh """

                    echo "Stopping and removing old container (if exists)..."
                    docker rm -f devopslabcontainer || true

                    docker run -d \
                    --name devopslabcontainer \
                    -p 8081:8081 \
                    yashodaadarsh/devopslab05images:${env.BUILD_NUMBER}
                """
            }
        }
    }
}