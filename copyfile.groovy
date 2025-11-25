pipeline {
    agent { label 'LAB-windows-EV' }

    parameters {
        choice(name: 'SERVER', choices: ['PPG-App01', 'PPG-App02'])
    }

    stages {

        stage('Copy Script to Remote Server') {
            steps {
                powershell """
                \$remotePath = "C:\\\\Temp\\\\day1.ps1"

                Copy-Item `
                    -Path "day1.ps1" `
                    -Destination "\\\\${params.SERVER}\\\\C\\\$\\\\Temp" `
                    -Force
                """
            }
        }

        stage('Run Remote Script') {
            steps {
                powershell """
                Invoke-Command `
                    -ComputerName ${params.SERVER} `
                    -ScriptBlock {
                        & "C:\\\\Temp\\\\day1.ps1"
                    }
                """
            }
        }
    }
}
