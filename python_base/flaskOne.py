from flask import Flask

# 实例化Flask对象
app = Flask(__name__)

# 生成路由关系，并把关系保存到某个地方,app对象的 url_map字段中
@app.route('/xxxx')  # @decorator
def index():
    return "Index"

# def index():
#     return "Index"
# app.add_url_rule('/xxx', "n1", index)

if __name__ == '__main__':
    # 启动程序，监听用户请求
    # 一旦请求到来，执行 app.__call__方法
    # 封装用户请求
    # 进行路由匹配
    app.run()