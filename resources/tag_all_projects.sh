#!/usr/bin/env bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

# Check number of arguments
if [[ $# -ne 2 ]]; then
    echo "Invalid arguments" >&2
    echo "$0 XML_FILE TAG_NAME" >&2
    echo "Ex. $0 latest.xml v0.1.2" >&2
    exit 1
fi

echo "DIR is $DIR"
