pipeline {
    agent any

    stages {

        stage('Checkout from GitHub') {
            steps {
                git branch: 'jenkins-dockerhub',
                    url: 'https://github.com/yashodaadarsh/DevOpsLab.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'npm install'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                docker build -t my-jenkins-dockerhub-app:${BUILD_NUMBER} .
                docker tag my-jenkins-dockerhub-app:${BUILD_NUMBER} yashodaadarsh/my-jenkins-dockerhub-app:${BUILD_NUMBER}
                '''
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                    echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                    docker push yashodaadarsh/my-jenkins-dockerhub-app:${BUILD_NUMBER}
                    docker logout
                    '''
                }
            }
}

//     stage('Start Minikube if not running') {
//     steps {
//         sh '''
//         if ! minikube status | grep -q "apiserver: Running"; then
//             echo "Minikube is not running. Starting now..."
//             minikube start --driver=docker --memory=2048 --cpus=2
//         fi
//         '''
//     }
// }

//         stage('Deploy to Kubernetes') {
//             steps {
//                 sh '''
//                 # Replace image tag inside deployment.yaml
//                 sed -i "s/IMAGE_TAG/${BUILD_NUMBER}/g" k8s/deployment.yaml

//                 # Load image into Minikube
//                 minikube image load yashodaadarsh/my-k8s-app:${BUILD_NUMBER}

//                 # Apply manifests
//                 minikube kubectl -- apply -f k8s/deployment.yaml
//                 minikube kubectl -- apply -f k8s/service.yaml
//                 '''
//             }
//         }
    }
}