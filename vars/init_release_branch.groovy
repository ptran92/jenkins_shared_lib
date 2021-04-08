def call(major_minor, branch, xmlfile, prefix) {
    withEnv([
        "ENV_RELEASE_MAJOR_MINOR=$major_minor",
        "ENV_RELEASE_BRANCH=$branch",
        "ENV_RELEASE_XML_FILE=$xmlfile"
        ]) {
        sh(script: libraryResource('init_release_branch.sh'), label: 'tag_all_projects')
    }

    // def nextVersion = ""

    // withEnv([
    //     "ENV_TARGET_MAJOR_MINOR_VERSION=$major_minor"
    //     ]) {
    //     nextVersion = sh(libraryResource('next_tag.sh'))
    // }

    // new way
    def nextVersion = next_tag(major_minor)

    withEnv([
        "ENV_RELEASE_XML_FILE=$xmlfile",
        "ENV_RELEASE_TAG=$prefix-$nextVersion",
        "ENV_RELEASE_XML_FILE=$xmlfile"
        ]) {
        sh(script: libraryResource('tag_all_projects.sh'), label: 'tag_all_projects')
    }

    sh(script: "echo \"current dir is \$PWD\"; ls -la")
    sh(script: "echo \"nextVersion is $nextVersion\"")
    sh(script: "git tag -f $nextVersion")
    // sh(script: "git push --atomic origin $branch $nextVersion")
}
