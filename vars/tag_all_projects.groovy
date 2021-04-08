def call(xmlfile, releasetag) {

    sh(script: "echo \"xmlfile is $xmlfile, releasetag is $releasetag\"")
    
    withEnv([
        "ENV_RELEASE_XML_FILE=$xmlfile",
        "ENV_RELEASE_TAG=$releasetag"
        ]) {
        sh(script: libraryResource('tag_all_projects.sh'), label: 'tag_all_projects')
    }
}
