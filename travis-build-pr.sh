#!/bin/bash
set -e

export EXIT_STATUS=0

echo "Executing tests for branch $TRAVIS_BRANCH"

./gradlew test || EXIT_STATUS=$?

exit $EXIT_STATUS
