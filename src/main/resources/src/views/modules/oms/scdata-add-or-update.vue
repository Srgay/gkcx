<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="schoolid">
      <el-input v-model="dataForm.schoolid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="provinceid">
      <el-input v-model="dataForm.provinceid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="provincename">
      <el-input v-model="dataForm.provincename" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="typename">
      <el-input v-model="dataForm.typename" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="batchname">
      <el-input v-model="dataForm.batchname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="max">
      <el-input v-model="dataForm.max" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="min">
      <el-input v-model="dataForm.min" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="year">
      <el-input v-model="dataForm.year" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          schoolid: '',
          provinceid: '',
          name: '',
          provincename: '',
          typename: '',
          batchname: '',
          max: '',
          min: '',
          year: ''
        },
        dataRule: {
          schoolid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          provinceid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          provincename: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          typename: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          batchname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          max: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          min: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/oms/scdata/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.schoolid = data.scdata.schoolid
                this.dataForm.provinceid = data.scdata.provinceid
                this.dataForm.name = data.scdata.name
                this.dataForm.provincename = data.scdata.provincename
                this.dataForm.typename = data.scdata.typename
                this.dataForm.batchname = data.scdata.batchname
                this.dataForm.max = data.scdata.max
                this.dataForm.min = data.scdata.min
                this.dataForm.year = data.scdata.year
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/oms/scdata/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'schoolid': this.dataForm.schoolid,
                'provinceid': this.dataForm.provinceid,
                'name': this.dataForm.name,
                'provincename': this.dataForm.provincename,
                'typename': this.dataForm.typename,
                'batchname': this.dataForm.batchname,
                'max': this.dataForm.max,
                'min': this.dataForm.min,
                'year': this.dataForm.year
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
