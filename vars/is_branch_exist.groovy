def call(branch_name) {
    withEnv(["ENV_BRANCH_NAME=$branch_name"]) {
        return sh(libraryResource('is_branch_existed.sh'))
    }
}
