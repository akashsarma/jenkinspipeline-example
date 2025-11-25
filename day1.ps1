# Print hostname
Write-Host "Hostname:"
hostname

# Print current date and time
Write-Host "Current Date & Time:"
Get-Date

# Define source and destination paths
$source = "C:\temp\source"
$destination = "C:\temp\destination"

# Check if source exists
if (Test-Path $source) {
    Write-Host "Moving files from $source to $destination ..."
    
    # Create destination if not exist
    if (!(Test-Path $destination)) {
        New-Item -ItemType Directory -Path $destination | Out-Null
    }

    # Move files
    Move-Item -Path "$source\*" -Destination $destination -Force

    Write-Host "Files moved successfully."
}
else {
    Write-Host "Source folder not found: $source"
}
