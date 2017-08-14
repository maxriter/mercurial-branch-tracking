#!/usr/bin/env bash
PROJECT_PATH=$1
BRANCH_NAME=$2

cd ~/branch-tracking-projects/$PROJECT_PATH && hg log -r "branch($BRANCH_NAME)" --limit 30