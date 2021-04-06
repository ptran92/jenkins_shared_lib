#!/usr/bin/env bash

# Check number of arguments
if [[ -z $ENV_BRANCH_NAME ]]; then
    echo "Invalid arguments" >&2
    echo "$0 BRANCH_NAME" >&2
    echo "Ex. $0 master" >&2
    exit 1
fi

BRANCH_NAME=$ENV_BRANCH_NAME

echo -n "Check branch $BRANCH_NAME"

BRANCH_EXISTED=`/usr/bin/env git rev-parse --quiet --verify ${BRANCH_NAME}`
TAGGED='no'
if [ ! -z "$BRANCH_EXISTED" ]; then
    TAGGED='yes'
fi
echo -n $TAGGED
