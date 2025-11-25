pipeline {
    agent { label 'LAB-windows-EV' }

    parameters {
        choice(
            name: 'SERVER',
            choices: ['PPG-App01', 'PPG-App02'],
            description: 'Select remote Windows server'
        )
    }

    stages {
        stage('Run PowerShell Script') {
            steps {
                powershell """
                # Optional: If using credentials stored in Jenkins
                # \$cred = Get-Credential

                Invoke-Command `
                    -ComputerName ${params.SERVER} `
                    -ScriptBlock {
                        Write-Host "Running script on remote server: ${params.SERVER}"
                        & "D:\\\\Jenkins\\\\Agent\\\\workspace\\\\windowsPSwith-git\\\\day1.ps1"
                    }
                """
            }
        }
    }
}
