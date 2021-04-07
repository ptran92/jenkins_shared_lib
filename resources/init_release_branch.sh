#!/usr/bin/env bash

RELEASE_MAJOR_MINOR=$(printenv ENV_RELEASE_MAJOR_MINOR)
RELEASE_BRANCH=$(printenv ENV_RELEASE_BRANCH)
RELEASE_XML_FILE=$(printenv ENV_RELEASE_XML_FILE)

# Create release branch
git config --global user.email "tran.thanh.bao.phu92@gmail.com"
git config --global user.name "Phu Tran"

echo "this is xml file" > ${RELEASE_XML_FILE}
git checkout -b ${RELEASE_BRANCH}
git add ${RELEASE_XML_FILE}
git commit -s -m "Initialize v${RELEASE_MAJOR_MINOR} release"
