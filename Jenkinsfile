

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
	agent { docker { image 'maven:3.6.3'}}
	stages {
		stage("Build") {
			steps {
				sh 'mvn --version'
				echo "Build"
			}
		}
		stage("Test") {
			steps {
				echo "Test"
			}
		}
		stage("Integration Test") {
			steps {
				echo "Integration Test"
			}
		}
	} 
	
	post {
		always {
			echo "This command runs always"
		}
		success {
			echo "this command executes only when all stages succeed"
		}
		failure {
			echo "this command executes when one of the stages failed"
		}
	}
}
