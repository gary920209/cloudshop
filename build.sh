#!/bin/bash
# Build script for cloudShop Java application

# Check if Java is installed
if command -v javac &>/dev/null; then
    echo "✅ Java is installed. Proceeding..."
else
    echo "❌ Java is not installed. Please install Java JDK to build this application."
    exit 1
fi

# Check if Maven is installed
if command -v mvn &>/dev/null; then
    echo "✅ Maven is installed. Using Maven to build the application..."

    # Run Maven compile
    mvn compile
    if [ $? -eq 0 ]; then
        echo "✅ Maven build completed successfully."
    else
        echo "❌ Maven build failed. Please check for errors."
        exit 1
    fi

    # Ask if user wants to run the project
    read -p "Do you want to run the project using Maven? (y/n): " run_option
    if [ "$run_option" = "y" ]; then
        main_class="src.main.java.com.Main"
        echo "Using default main class: $main_class"
        mvn exec:java -Dexec.mainClass="$main_class"
    fi
else
    echo "⚠️ Maven is not installed. Falling back to manual Java compilation..."

    # Create a directory for compiled classes
    mkdir -p classes

    # Compile all Java files
    javac -d classes $(find src -name "*.java")

    if [ $? -eq 0 ]; then
        echo "✅ Manual build completed successfully."
    else
        echo "❌ Manual build failed. Please check for errors."
        exit 1
    fi
fi
