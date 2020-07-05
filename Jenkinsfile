

//scripted pipeline
//node {
//	stage('Build') {
//		echo "Build"
//	}
//	stage('Test') {
//		echo "Test"
//	}
//	stage('Integration Test') {
//		echo "Integration Test"
//	}
//}

//node {
//	echo "Build"
//	echo "Test"
//	echo "Integration Test"
//}

//declarative
pipeline {
	//agent any
	//agent { docker { image 'maven:3.6.3'}}
	//agent { docker { image 'node:14.5.0'}}

	agent { docker { image 'maven:3.6.3'}}

	environment {
		dockerHome = tool "myDocker"
		mavenHome = tool "myMaven"
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}

	stages {
		stage("Checkout") {
			steps {
				sh 'mvn --version'
				sh 'docker --version'
				//sh 'node --version'
				echo "Build"
				echo "PATH - $PATH"
				echo "BUILD NUMBER - $env.BUILD_NUMBER"
				echo "BUILD ID - $env.BUILD_ID"
				echo "JOB NAME - $env.JOB_NAME"
				echo "BUILD TAG - $env.BUILD_TAG"
				echo "BUILD URL - $env.BUILD_URL"
			}
		}
		stage("Compile") {
			steps {
				sh "mvn clean compile"
			}
		}
		stage("Test") {
			steps {
				sh "mvn test"
			}
		}
		stage("Integration Test") {
			steps {
				sh "mvn failsafe:integration-test failsafe:verify"
			}
		}
	} 
	
	post {
		always {
			echo "This command runs always"
		}
		success {
			echo "this command executes only when all stages succeed"
			//mail bcc: '', body: 'TEST Sending SUCCESS email from jenkins', cc: '', from: '', replyTo: '', subject: 'SUCCESS BUILDING PROJECT X', to: 'andre.consultant@gmail.com'
		}
		failure {
			echo "this command executes when one of the stages failed"
			//mail bcc: '', body: 'TEST Sending FAILURE email from jenkins', cc: '', from: '', replyTo: '', subject: 'ERROR BUILDING PROJECT X', to: 'andre.consultant@gmail.com'
		}
	}
}
