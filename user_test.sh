#!/bin/bash

CLI_CMD="java -cp target/classes src.main.java.com.Main"

# Test 1: Register user
OUTPUT=$($CLI_CMD REGISTER user1)
EXPECTED="Success"
if [ "$OUTPUT" == "$EXPECTED" ]; then
    echo "✅ REGISTER test passed"
else
    echo "❌ REGISTER test failed: Expected '$EXPECTED', but got '$OUTPUT'"
    exit 1
fi
