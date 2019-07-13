#!/bin/bash
echo "Input the stack name which you want to terminate"
read name

aws cloudformation delete-stack --stack-name $name
aws cloudformation wait stack-delete-complete --stack-name $name

echo "Stack succesfully terminated"