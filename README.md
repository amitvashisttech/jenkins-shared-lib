### 1. Create a Shared Library Repository:

Start by creating a new Git, Mercurial, or other version control repository for your shared library. This repository will contain the code that you want to share across different Jenkins pipelines.

### 2. Define the Directory Structure:

In your shared library repository, define the following directory structure:
```
shared-library/
└── src/
    └── org/
        └── yourcompany/
            └── Jenkinsfile
            └── YourLibrary.groovy
```

### 3. Write Your Shared Library Code:

Open YourLibrary.groovy and define your shared code. For example:
```
package org.yourcompany

def call() {
    echo "Hello from the shared library!"
}

def customStep() {
    echo "This is a custom step."
}
```

### 4. Commit and Push Changes:

Commit your changes to the shared library repository and push them to the version control system.

### 5. Configure Jenkins to Use the Shared Library:

Open Jenkins and navigate to "Manage Jenkins" > "Configure System."

Find the "Global Pipeline Libraries" section.

Add a new library:
```
    Name: Give your library a name (e.g., MySharedLibrary).
    Default Vesion: would be your git repo banch name. 
    Source Code Management: Choose the version control system (e.g., Git).
    Project Repository: Provide the URL to your shared library repository.
```
Save the configuration.

### 6. Use the Shared Library in Jenkins Pipelines:

In your Jenkins pipeline scripts, you can now use the shared library:
```
@Library('MySharedLibrary') _
// This will load the shared library

pipeline {
    agent any

    stages {
        stage('Example') {
            steps {
                YourLibrary() // Invoking the shared library function
                customStep() // Invoking a custom step
            }
        }
    }
}
```

@Library('MySharedLibrary') _: This directive loads the shared library into your pipeline.

### 7. Run the Pipeline:

Run a pipeline that uses the shared library, and Jenkins will automatically fetch the library from the configured repository.
