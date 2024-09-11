#!/bin/sh
# Setting Environment Variables
chmod +x env.sh
. ./env.sh

# Function to handle errors and exit with a message
exit_with_error() {
  echo "$1"
  exit 1
}

# Function to clone the Git repositories if they don't exist
clone_repo_if_not_exists() {
  local repo_name="$1"
  local repo_url="$2"
  if [ ! -d "$repo_name" ]; then
    git clone -b develop "$repo_url"
  fi
}

# Function to build the project and exit if the build fails
build_and_exit_on_failure() {
  local project_dir="$1"
  cd "$project_dir" || exit
  ./gradlew clean && ./gradlew bootJar || exit_with_error "Build failed. Please Ensure Your Java Version is 11"
}

# Fetch the directory containing the current bash file
CURR_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

mkdir -p ~/dev && cd ~/dev || exit

# Change to the directory containing the Docker Compose file
cd "$CURR_DIR" || exist

# Run Docker Compose
docker-compose up -d || exit
echo "BUILD SUCCESS"
