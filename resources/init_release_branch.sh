#!/usr/bin/env bash

# Get user inputs
RELEASE_MAJOR_MINOR=$ENV_RELEASE_MAJOR_MINOR
RELEASE_BRANCH=$ENV_RELEASE_BRANCH
RELEASE_XML_FILE=$ENV_RELEASE_XML_FILE
RELEASE_TAG_PREDFIX=$ENV_RELEASE_TAG_PREDFIX

# Create release branch
echo "this is xml file" > ${RELEASE_XML_FILE}
git checkout -b ${RELEASE_BRANCH}
git add ${RELEASE_XML_FILE}
git commit -s -m "Initialize v${RELEASE_MAJOR_MINOR} release"

# Force tag
NEXT_TAG=`./next_tag.sh ${RELEASE_MAJOR_MINOR}`
./tag_all_projects.sh ${RELEASE_XML_FILE} "${RELEASE_TAG_PREDFIX}-${NEXT_TAG}"
git tag -f ${NEXT_TAG}

# Push tag and branch simultanously to avoid dirty git version
git push --atomic origin ${RELEASE_BRANCH} ${NEXT_TAG}
