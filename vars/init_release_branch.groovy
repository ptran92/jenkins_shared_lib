def call(major_minor, branch, xmlfile, prefix) {
    withEnv([
        "ENV_RELEASE_MAJOR_MINOR=$major_minor",
        "ENV_RELEASE_BRANCH=$branch",
        "ENV_RELEASE_XML_FILE=$xmlfile"
        ]) {
        sh(script: libraryResource('init_release_branch.sh'), label: 'tag_all_projects')
    }

    def nextVersion = next_tag(major_minor)

    tag_all_projects(xmlfile, "$prefix-$nextVersion")

    sh(script: "echo \"current dir is \$PWD\"; ls -la")
    sh(script: "echo \"nextVersion is $nextVersion\"")
    sh(script: "git tag -f $nextVersion")
    // sh(script: "git push --atomic origin $branch $nextVersion")
}
