from flask import Flask
from flask import jsonify
# app是Flask的实例，它接收包或者模块的名字作为参数，但一般都是传递__name__
app = Flask(__name__)
# 定义一个列表
list1=[
    {
        "id":"1",
        "text":"这是id1的文本"
    },
    {
        "id":"2",
        "text":"这是id2的文本"
    }
]
# 定义路由与请求方式
@app.route("/test1",methods=["get"])
# 定义返回函数为list1的内容
def get_list1():
    return jsonify(list1)
# 设置主机与端口
if __name__ == '__main__':
    app.run(host='0.0.0.0',port=9000)
