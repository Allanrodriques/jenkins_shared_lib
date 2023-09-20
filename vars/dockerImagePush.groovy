// def call(String project,String ImageTag, String hubUser){
//     withCredentials([usernamePassword(
//                                 credentialsId: 'docker', 
//                                 passwordVariable: 'PASS', 
//                                 usernameVariable: 'USER'
//                     )]) {
//     sh "docker login -u ${USER} -p ${PASS}"
//     sh "docker image push ${hubUser}/${project}:${ImageTag}"
//     sh "docker image push ${hubUser}/${project}:latest"
// }
// }
def call(String awsaccount_id,String region, String ecr_repoName){
    sh "aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 407965543264.dkr.ecr.us-east-1.amazonaws.com"
    sh "docker push ${awsaccount_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest"
} 
