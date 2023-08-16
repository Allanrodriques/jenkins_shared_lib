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
    // sh "aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${awsaccount_id}.dkr.ecr.${region}.amazonaws.com"
    sh "docker push ${awsaccount_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest"
} 