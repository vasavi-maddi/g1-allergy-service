properties([pipelineTriggers([githubPush()])])
pipeline{
	agent any
	stages{
		stage('Checkout'){
			steps{
				
				git branch: "main", url: 'https://github.com/vasavi-maddi/g1-allergy-service.git'
				
			
			}
			
		}
		
		stage('Build'){
			steps{
				sh 'chmod a+x mvnw'
				sh './mvnw clean package -DskipTests=true' 
			}
			
			post{
				always{
					archiveArtifacts 'target/*.jar'
				}
			}
		}
      stage('DockerBuild') {
            steps {
                sh 'docker build -t vasavi19/vasavi-spring-app:latest .'
            }
        }
        stage('Login') {

			steps {
				sh 'echo Vasavi#19 | docker login -u vasavi19 --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push vasavi19/vasavi-spring-app'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}
   }
