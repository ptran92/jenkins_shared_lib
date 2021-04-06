#!/usr/bin/env bash


TARGET_MAJOR_MINOR_VERSION=$ENV_TARGET_MAJOR_MINOR_VERSION
echo TARGET_MAJOR_MINOR_VERSION=$TARGET_MAJOR_MINOR_VERSION >&2

SEARCH_TAG="v${TARGET_MAJOR_MINOR_VERSION}.*"
LAST_BUILD_VER=`git describe --tags --match="$SEARCH_TAG" --abbrev=0`
echo LAST_BUILD_VER=$LAST_BUILD_VER >&2

NEXT_TAG="Unknown"
if [ -z $LAST_BUILD_VER ]; then
    echo "Couldn't find last build number, tagging first build of a new version" >&2
    NEXT_TAG="v${TARGET_MAJOR_MINOR_VERSION}.0"
else
    echo "Found last build number, increasing for next tag" >&2
    IFS='.' read -a array <<< "$LAST_BUILD_VER"
    LAST_VAL=${array[2]}
    LAST_VAL=$(expr $LAST_VAL + 1)
    NEXT_TAG="${array[0]}.${array[1]}.$LAST_VAL"
fi

echo NEXT_TAG=$NEXT_TAG >&2
echo -n "${NEXT_TAG}"
