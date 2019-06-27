# -*- coding: utf-8 在flask下面完成文件的上传 -*-
import os
import uuid
import platform
from flask import Flask, request, redirect, url_for
from werkzeug.utils import secure_filename

if platform.system() == "Windows":
    slash = '\\'
else:
    platform.system() == "Linux"
    slash = '/'
UPLOAD_FOLDER = 'upload'
ALLOW_EXTENSIONS = set(['html', 'jpg','png','bmp','htm', 'doc', 'docx', 'mht', 'pdf'])
app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
# 判断文件夹是否存在，如果不存在则创建
if not os.path.exists(UPLOAD_FOLDER):
    os.makedirs(UPLOAD_FOLDER)
else:
    pass

# 判断文件后缀是否在列表中
def allowed_file(filename):
    return '.' in filename and \
           filename.rsplit('.', 1)[1] in ALLOW_EXTENSIONS

@app.route('/upload', methods=['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        # 获取post过来的文件名称，从name=file参数中获取
        file = request.files['file']
        if file and allowed_file(file.filename):
            # secure_filename方法会去掉文件名中的中文
            filename = secure_filename(file.filename)
            # 因为上次的文件可能有重名，因此使用uuid保存文件
            file_name = str(uuid.uuid4()) + '.' + filename.rsplit('.', 1)[1]
            file.save(os.path.join(app.config['UPLOAD_FOLDER'], file_name))
            base_path = os.getcwd()
            file_path = base_path + slash + app.config['UPLOAD_FOLDER'] + slash + file_name
            print(file_path)
            return redirect(url_for('upload_file', filename=file_name))
    return '上传文件成功'

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000)