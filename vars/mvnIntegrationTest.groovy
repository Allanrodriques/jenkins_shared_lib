def call(){
    sh 'mvn verify -DskipITsTests'
}