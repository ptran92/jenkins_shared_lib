#!/usr/bin/env bash

# Get user inputs
if [[ $# -ne 3 ]]; then
    echo "Invalid arguments" >&2
    echo "Num arguments is $#"
    exit 1
fi

# Get user inputs
RELEASE_MAJOR_MINOR=$1
RELEASE_BRANCH=$2
RELEASE_XML_FILE=$3

# RELEASE_MAJOR_MINOR=$ENV_RELEASE_MAJOR_MINOR
# RELEASE_BRANCH=$ENV_RELEASE_BRANCH
# RELEASE_XML_FILE=$ENV_RELEASE_XML_FILE

# Create release branch
git config --global user.email "tran.thanh.bao.phu92@gmail.com"
git config --global user.name "Phu Tran"

echo "this is xml file" > ${RELEASE_XML_FILE}
git checkout -b ${RELEASE_BRANCH}
git add ${RELEASE_XML_FILE}
git commit -s -m "Initialize v${RELEASE_MAJOR_MINOR} release"
