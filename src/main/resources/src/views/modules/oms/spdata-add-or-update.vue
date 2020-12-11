<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="min">
      <el-input v-model="dataForm.min" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="minsection">
      <el-input v-model="dataForm.minsection" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="spname">
      <el-input v-model="dataForm.spname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="schoolid">
      <el-input v-model="dataForm.schoolid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="provincename">
      <el-input v-model="dataForm.provincename" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="typename">
      <el-input v-model="dataForm.typename" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="batchname">
      <el-input v-model="dataForm.batchname" placeholder=""></el-input>
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
          min: '',
          minsection: '',
          spname: '',
          schoolid: '',
          provincename: '',
          name: '',
          typename: '',
          batchname: '',
          year: ''
        },
        dataRule: {
          min: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          minsection: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          spname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          schoolid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          provincename: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          typename: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          batchname: [
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
              url: this.$http.adornUrl(`/oms/spdata/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.min = data.spdata.min
                this.dataForm.minsection = data.spdata.minsection
                this.dataForm.spname = data.spdata.spname
                this.dataForm.schoolid = data.spdata.schoolid
                this.dataForm.provincename = data.spdata.provincename
                this.dataForm.name = data.spdata.name
                this.dataForm.typename = data.spdata.typename
                this.dataForm.batchname = data.spdata.batchname
                this.dataForm.year = data.spdata.year
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
              url: this.$http.adornUrl(`/oms/spdata/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'min': this.dataForm.min,
                'minsection': this.dataForm.minsection,
                'spname': this.dataForm.spname,
                'schoolid': this.dataForm.schoolid,
                'provincename': this.dataForm.provincename,
                'name': this.dataForm.name,
                'typename': this.dataForm.typename,
                'batchname': this.dataForm.batchname,
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
