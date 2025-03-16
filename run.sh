#!/bin/bash
# Run script for cloudShop Java application

# Check if classes directory exists
if [ ! -d "classes" ]; then
    echo "Classes directory not found. Run build.sh first."
    exit 1
fi

# Run the Java application
java -cp classes src.java.com.Main