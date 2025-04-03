#!/bin/bash

CLI_CMD="java -cp target/classes src.main.java.com.Main"

# Test 1: Register user
OUTPUT=$(echo "REGISTER user1" | $CLI_CMD)
EXPECTED="Success"
if [ "$OUTPUT" == "$EXPECTED" ]; then
    echo "✅ REGISTER test passed"
else
    echo "❌ REGISTER test failed: Expected '$EXPECTED', but got '$OUTPUT'"
    exit 1
fi