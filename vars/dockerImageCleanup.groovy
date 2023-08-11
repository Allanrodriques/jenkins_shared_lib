// def call(String project,String ImageTag, String hubUser){
//     sh """
//     docker rmi ${hubUser}/${project}:${ImageTag}
//     docker rmi ${hubUser}/${project} ${hubUser}/${project}:latest
//     """
// } 
def call(String awsaccount_id,String region, String ecr_repoName){
    sh """
        docker rmi ${ecr_repoName}:latest ${awsaccount_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}