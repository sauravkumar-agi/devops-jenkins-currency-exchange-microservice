

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
	agent any
	stages {
		stage("Build") {
			echo "Build"
			echo "Test"
			echo "Integration Test"
		}
	}
}
