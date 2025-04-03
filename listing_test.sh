#!/bin/bash

CLI_CMD="java -cp target/classes src.main.java.com.Main"

# Pass all commands in one session to maintain state
OUTPUT=$($CLI_CMD <<EOF
REGISTER user1
CREATE_LISTING user1 'Phone model 8' 'Black color, brand new' 1000 'Electronics'
GET_LISTING user1 100001
EOF
)

# Parse output for each command
REGISTER_OUTPUT=$(echo "$OUTPUT" | sed -n '1p')
CREATE_LISTING_OUTPUT=$(echo "$OUTPUT" | sed -n '2p')

# Test 1: Register user
EXPECTED="Success"
if [ "$REGISTER_OUTPUT" == "$EXPECTED" ]; then
    echo "✅ REGISTER test passed"
else
    echo "❌ REGISTER test failed: Expected '$EXPECTED', but got '$REGISTER_OUTPUT'"
    exit 1
fi

# Test 2: Create listing
EXPECTED="100001"
if [ "$CREATE_LISTING_OUTPUT" == "$EXPECTED" ]; then
    echo "✅ CREATE_LISTING test passed"
else
    echo "❌ CREATE_LISTING test failed: Expected '$EXPECTED', but got '$CREATE_LISTING_OUTPUT'"
    exit 1
fi
