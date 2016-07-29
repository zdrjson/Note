#! /bin/sh

echo "hello shell!"
variable_name=ghui
variable_name="ghui's blog"

num=111 #全局变量
fun1()
{
	local num=222 #局部变量
	echo $num
}
echo "before---$num"
fun1
echo "after---$num"

name=ghui
echo $name
echo ${name} #为了帮助解释器识别变量边界，非必须

#！/bin/sh
str='abc'
echo "1 print $str"
echo '2 print $str'

name="shell"
sayHi="hello, "$name" !"
sayHi2="hello, ${name} !"
echo $sayHi $sayHi2


string="abcd"
echo ${#string} #输出： 4

str="hello shell"
echo ${str:2} #输出： llo shell
echo ${string:1:3} #输出：ell


a=1
#if [ $1=$a ]
#then
#	echo "you input 1"
#elif [ $1=2 ]
#    echo "you input 2"	
#else 
#	#do nothing
#	echo " you input $1"
#fi


#if test "2>3"
#then 
#fi
#
#if [ "2>3" ]
#then
#fi


input=$1
case $input in
        1 | 0)
	    str="一or零";;
	    2)
	    str="二";;
	    3)
	    str="三";;
	    *)
	    str=$input;;
esac
echo "---$str"


#for file in *.txt
#do 
#	open $file
#done


i=0
while ((i<5))
do 
	((i++))
	echo "i=$i"
done

i=5
until ((i==0))
do 
	((i--))
	echo "i=$i"
done
	
# ad.sh 计算sum
add()
{
	let "sum=$1+$2"
	return $sum
}

add $1 $2
echo "sum=$?"

# test.sh
echo "$# parameters";
echo "$@";
echo "$0"
echo "$1"





	






