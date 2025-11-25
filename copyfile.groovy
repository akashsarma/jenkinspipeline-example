pipeline {
    agent { label 'LAB-windows-EV' }

    parameters {
        choice(name: 'SERVER', choices: ['PPG-App01', 'PPG-App02'])
    }

    stages {
        stage('Run PowerShell Script') {
            steps {
                powershell """
                Invoke-Command -ComputerName ${params.SERVER} -ScriptBlock {
                    # Run your PS1 file
                     D:\\Jenkins\\Agent\\workspace\\windowsPSwith-git\\day1.ps1
                }
                """
            }
        }
    }
}
